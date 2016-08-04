<?php
  $connect = mysql_connect("localhost", "wbatw2003", "tldk0914");
  // db와 연결을 시도합니다.
  if(!$connect) {
       die('Could not connect : '.mysql_error());
  }
  // db를 선택합니다.
  mysql_select_db("wbatw2003",$connect);
  // 한국어로 입력 가능하도록 설정합니다.
  mysql_query("set names utf8");
  // INSERT 쿼리 명령어로 테이블에 삽입합니다.
  // INSERT INTO 테이블명
  // INSERT INTO 테이블명 (필드명,필드명) VALUES (‘$_POST[]’,$_POST[]);
  // $_POST[]는 app 또는 web에서 post로 전송한 데이터를 입력받습니다.
  $qry = "INSERT INTO information (user_id, user_name, user_password, user_ph, user_email) VALUES('$_POST[user_id]','$_POST[user_name]','$_POST[user_password]','$_POST[user_ph]','$_POST[user_email]')";
  // 쿼리를 실행합니다.
  if(!mysql_query($qry,$connect)) {
       die('Error : '.mysql_error());
  }
  echo "1 record added";
  // db 연결을 닫습니다.
  mysql_close($connect);
?>