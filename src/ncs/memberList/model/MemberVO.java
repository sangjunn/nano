package ncs.memberList.model;

import java.util.Calendar;

//memberDTO
public class MemberVO {
   private String userId;
   private String userName;
   private String birthday;
   private Integer gender;

   public MemberVO() {
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getBirthday() {
      return birthday;
   }

   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }

   public Integer getGender() {
      return gender;
   }

   public void setGender(Integer gender) {
      this.gender = gender;
   }

   public int getAge() {
      Calendar currentDate = Calendar.getInstance();
      int currentYear = currentDate.get(Calendar.YEAR);
      int age = 0;
      try {
         age = currentYear - Integer.parseInt(birthday.substring(0, 4)) + 1;
      } catch (NumberFormatException e) {
         e.printStackTrace();
      }
      return age;
   }

   public String getSexual() {
      if (gender == 1)
         return "남";
      else
         return "여";
   }

}