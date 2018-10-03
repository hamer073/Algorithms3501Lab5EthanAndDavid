public class Bin{
  private Company company;
  private Programmer programmer;

  public Bin(Company givenCompany, Programmer givenProgrammer){
    this.company = givenCompany;
    this.programmer = givenProgrammer;
  }

  public Company getCompany(){
    return this.company;
  }

  public Programmer getProgrammer(){
    return this.programmer;
  }

  public void setProgrammer(Programmer givenProgrammer) { this.programmer = givenProgrammer; }
}
