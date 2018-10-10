public class Company{
  private Programmer[] programmerPreferences;
  private int currentPref = 0;
  private final String name;

  public Company(String name){
      this.name = name;
  }

  /*
  public String toString(){
    return this.getName();
  }
  */

  public void setProgrammerPreferences(Programmer[] preferences){
      this.programmerPreferences = preferences;
  }

  public Programmer[] getProgrammerPreferences() { return this.programmerPreferences; }

  public Programmer getNextProgrammer(){
      currentPref = (currentPref + 1) % (programmerPreferences.length);
      return programmerPreferences[currentPref];
  }

  public String getName(){
      return this.name;
  }

}