package CAS.Data;

public class Course
{
 private int id;
 private String workarea;
 private Instructor instructor;
 private Day[] day;
 private Time start;
 private Time end;
 private String subject;
 private int number;
 private String section;
 private int session;
 private String title;
 private int credits;
 private String campus;
 private String room;

 public Course(){
 }

 public int hashCode(){
  String hash = number + title;
  return hash.hashCode();
 }

 public boolean equals(Course course){
  if(number != course.number)
      return false;
  if(!subject.equals(course.subject))
      return false;
  if(!title.equals(course.title))
      return false;
  if(credits != course.credits)
      return false;
  return true;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getWorkarea() {
  return workarea;
 }

 public void setWorkarea(String workarea) {
  this.workarea = workarea;
 }

 public Instructor getInstructor() {
  return instructor;
 }

 public void setInstructor(Instructor instructor) {
  this.instructor = instructor;
 }

 public Day[] getDay() {
  return day;
 }

 public void setDay(Day[] day) {
  this.day = day;
 }

 public Time getStart() {
  return start;
 }

 public void setStart(Time start) {
  this.start = start;
 }

 public Time getEnd() {
  return end;
 }

 public void setEnd(Time end) {
  this.end = end;
 }

 public String getSubject() {
  return subject;
 }

 public void setSubject(String subject) {
  this.subject = subject;
 }

 public String getSection() {
  return section;
 }

 public void setSection(String section) {
  this.section = section;
 }

 public int getSession() {
  return session;
 }

 public void setSession(int session) {
  this.session = session;
 }

 public int getCredits() {
  return credits;
 }

 public void setCredits(int credits) {
  this.credits = credits;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getCampus() {
  return campus;
 }

 public void setCampus(String campus) {
  this.campus = campus;
 }

 public String getRoom() {
  return room;
 }

 public void setRoom(String room) {
  this.room = room;
 }
 
 public void setNumber(int number){
  this.number = number;
 }
 
 public int getNumber(){
  return number;
 }
}