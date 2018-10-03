public class Company{
  private Programmer[] programmerPreferences;
  private int currentPref = 0;

  public Company(Programmer[] givenPreferences){
    this.programmerPreferences = givenPreferences;
  }

  /*
  public String toString(){
    return this.getName();
  }
  */

  public Programmer[] getProgrammerPreferences() { return this.programmerPreferences; }

  public Programmer getNextProgrammer(){
      currentPref++;
      return programmerPreferences[currentPref];
  }

}