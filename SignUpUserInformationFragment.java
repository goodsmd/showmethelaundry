public class SignUpUserInformationFragment extends Fragment implements View.OnClickListener{


   public int view_id = 0;
   public String symbolvalue;

   private DB_Manager db_manager;
   private DB_Define db_define;
   private ArrayList<String> results;

   private EditText et_id;
   private EditText et_name;
   private EditText et_passWord;
   private EditText et_passWordAgain;
   private EditText et_phone;
   private EditText et_email;

   public SignUpUserInformationFragment() {

   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {

       View rootView = inflater.inflate(R.layout.fragment_signup_user_information, container, false);
       et_id = (EditText)rootView.findViewById(R.id.user_id);
       et_name = (EditText)rootView.findViewById(R.id.user_name);
       et_passWord = (EditText)rootView.findViewById(R.id.user_passWord);
       et_passWordAgain = (EditText) rootView.findViewById(R.id.user_passWordAgain);
       et_phone = (EditText) rootView.findViewById(R.id.user_Phone);
       et_email = (EditText) rootView.findViewById(R.id.user_Email);
       Button btn_agreeJoin = (Button) rootView.findViewById(R.id.btn_agreeJoin);

       et_id.setOnClickListener(this);
       et_name.setOnClickListener(this);
       et_passWord.setOnClickListener(this);
       et_passWordAgain.setOnClickListener(this);
       et_phone.setOnClickListener(this);
       et_email.setOnClickListener(this);
       btn_agreeJoin.setOnClickListener(this);

       db_manager = new DB_Manager();

       results = new ArrayList<String>();

       return rootView;
   }

   @Override
   public void onClick(View view) {

       //*밑 4줄은 비밀번호와 비밀번호 확인을 해서 서로 일치한지 비교해주기 위해 둘 모두 String으로 변환하여 비교해준다.
       String a = et_passWord.getText().toString();
       String b = et_passWordAgain.getText().toString();

       //signup_id에 아이디들을 스위치문으로 받아와준다.
       switch (view.getId()) {
           case R.id.user_id:
               popup(R.id.user_id, "아이디입력");
               break;
           case R.id.user_name:
               popup(R.id.user_name, "이름 입력");
               break;
           case R.id.user_Email:
               popup(R.id.user_Email, "이메일을 입력 해주세요");
               break;
           case R.id.user_Phone:
               // 핸드폰 번호 따오는 알고리즘
               TelephonyManager systemService = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
               String PhoneNumber = systemService.getLine1Number();
               PhoneNumber = PhoneNumber.substring(PhoneNumber.length() - 10, PhoneNumber.length());
               PhoneNumber = "0" + PhoneNumber;
               // 얻어온 전화번호에 자동으로 하이픈(-) 추가
               //PhoneNumber = PhoneNumberUtils.formatNumber(PhoneNumber);
               et_phone.setText(PhoneNumber);
               // 해당 에디트텍스트를 사용자입력 금지시킴
               et_phone.setEnabled(false);
               break;
           case R.id.btn_agreeJoin:
               FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
               /*
               if (et_id.length() < 1) {
                   Toast.makeText(getActivity(), "아이디가 공백입니다!", Toast.LENGTH_SHORT).show();
                   break;
               }
               if (et_name.length() < 1) {
                   Toast.makeText(getActivity(), "이름이 공백입니다!", Toast.LENGTH_SHORT).show();
                   break;
               }
               if (et_phone.length() < 1) {
                   Toast.makeText(getActivity(), "전화번호가 공백입니다!", Toast.LENGTH_SHORT).show();
                   break;
               }
               if (et_email.length() < 1) {
                   Toast.makeText(getActivity(), "메일이 공백입니다!", Toast.LENGTH_SHORT).show();
                   break;
               }
               */
               if(a.length()<1)
                   Toast.makeText(getActivity(), "비밀번호가 공백입니다!", Toast.LENGTH_SHORT).show();
               else if (!a.equals(b))
                   Toast.makeText(getActivity(), "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
               else {
                   String user_id = et_id.getText().toString();
                   String user_name = et_name.getText().toString();
                   String user_password = et_passWord.getText().toString();
                   String user_phone = et_phone.getText().toString();
                   String user_email = et_email.getText().toString();
	        dbmanger.signup_user_information(user_id, user_name, user_password, user_phone, user_email);
                   Intent mainIntent = new Intent(getActivity(), SignUpPhotoActivity.class);
                   startActivity(mainIntent);
               }
               break;
       }

   }
   //밑에는 popup을 만들어주는 함수이다.
   public void popup(final int id, String title) {
       view_id = id;
       Context mContext = getActivity().getApplicationContext();
       LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

       //R.layout.dialog는 xml 파일명이고  R.id.popup은 보여줄 레이아웃 아이디
       final View layout = inflater.inflate(R.layout.popup_signup, (ViewGroup) getActivity().findViewById(R.id.popupId));
       final AlertDialog.Builder aDialog = new AlertDialog.Builder(getActivity());

       aDialog.setTitle(title); //타이틀바 제목
       aDialog.setView(layout); //dialog.xml 파일을 뷰로 셋팅
       aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int which) {
           }
       });

       //밑에는 팝업창에서 정보들을 입력한 후 확인을 누르면 EditText자리에 그대로 String으로 나타내주기 위한 함수이다.
       aDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                       if (view_id == R.id.user_id) {
                           EditText edit = (EditText) ((AlertDialog) dialog).findViewById(R.id.enterId); //팝업창에 EditText부분에 아이디
                           symbolvalue = edit.getText().toString();
                           /**
                               읿력받은 id와 서버의 저장되어 있는 id를 조회하여 중복되는 지 여부를 검사한다.
                           */
                           results = db_manager.inquiryUser(symbolvalue, "");
                           String[] result_query = results.get(0).split(":"); // Split input string
                           String isExistId = result_query[4];
                           String isExistPw = result_query[6];
                           Log.d("isExistID:", isExistId);
                           Log.d("isExistPassword:", isExistPw);
                           if (isExistId.equals(db_define.IS_EXIST_ID)) { // If id existed in db and correspond
                               symbolvalue = "";
                               Toast.makeText(getActivity(), "아이디가 중복입니다", Toast.LENGTH_SHORT).show();
                           }
                           TextView text = (TextView) getActivity().findViewById(id);//각 항목에 대한 id를 받아온다.
                           edit.requestFocus();
                           text.setText(symbolvalue);
                       } else {
                           EditText edit = (EditText) ((AlertDialog) dialog).findViewById(R.id.enterId); //팝업창에 EditText부분에 아이디
                           symbolvalue = edit.getText().toString();
                           edit.requestFocus();
                           TextView text = (TextView) getActivity().findViewById(id);//각 항목에 대한 id를 받아온다.
                           text.setText(symbolvalue);
                       

                   }
               }

       );
           //그냥 닫기버튼을 위한 부분
           //팝업창 생성
           AlertDialog ad = aDialog.create();
           ad.show();//보여줌!
       }
   }