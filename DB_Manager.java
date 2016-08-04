public class DB_Manager {
private String urlPath;
// 회원 가입의 정보를 MySQL에 저장할 php를 포함한 도메인 주소를 입력한다.
private final String signup_user_information_UrlPath = 
"http://wbatw2003.cafe24.com/user_signup/signup_user_information.php
";

/*-- DB user에 접속하여 회원 가입에 관한 db 저장할 데이터 */
private String user_id;
private String user_name;
private String user_password;
private String user_phone;
private String user_email;

//함수 인자로 입력받은 유저의 아이디와 이름과 비밀번호, 핸드폰 번호, 이메일을 넘겨 받습니다.
//이후에 SignupUserInformation() 클래스를 실행합니다.

/* 회원가입 부분 */
/* -- 유저에게 id,password,핸드폰,이메일을 입력받는다. */
public ArrayList<String> signup_user_information(String user_id, String user_name, String user_password, String user_phone, String user_email) {
   urlPath = signup_user_information_UrlPath;
   this.user_id = user_id;
   this.user_name = user_name;
   this.user_password = user_password;
   this.user_phone = user_phone;
   this.user_email = user_email;
   try {
       results = new SignupUserInformation().execute().get();
   } catch ( InterruptedException e ) {
       e.printStackTrace();
   } catch ( ExecutionException e ) {
       e.printStackTrace();
   }
   return results;
}
/* 회원가입 부분 */
/* -- 문자열로 이루어진 데이터를 서버에 POST 방식으로 전송한다 */
class SignupUserInformation extends AsyncTask<Void, Void, ArrayList<String>> {
   @Override
   protected ArrayList<String> doInBackground(Void... voids) {
       // TODO Auto-generated method
       try {
           URL url = new URL(urlPath); // Set url
           HttpURLConnection con = (HttpURLConnection) url.openConnection();
           con.setDoInput(true); // Available Write
           con.setDoOutput(true); // Available Read
           con.setUseCaches(false); // No cash
           con.setRequestMethod("POST");

           String param = "user_id="+user_id+"&user_name="+user_name+"&user_password="+user_password+"&user_phone="+user_phone+
                   "&user_email="+user_email;

           OutputStream outputStream = con.getOutputStream();
           outputStream.write(param.getBytes());
           outputStream.flush();
           outputStream.close();

           BufferedReader rd = null;
           rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
           String line = null;
           while((line = rd.readLine()) != null) {
               Log.d("BufferedReader:", line);
           }
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return null;
   }
   protected void onPostExecute(ArrayList<String> qResults) {
       super.onPostExecute(qResults);
   }
}