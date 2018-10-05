public class Test {
    public static void main(String[] args){

        MakeSatisfactory run = new MakeSatisfactory();

        Company A = new Company("A");
        Company B = new Company("B");
        Company C = new Company("C");
        Company D = new Company("D");
        Company E = new Company("E");

        Programmer One = new Programmer("One");
        Programmer Two = new Programmer("Two");
        Programmer Three = new Programmer("Three");
        Programmer Four = new Programmer("Four");
        Programmer Five = new Programmer("Five");

        A.setProgrammerPreferences(new Programmer[] {Two, Five, One, Three, Four});
        B.setProgrammerPreferences(new Programmer[] {One, Two, Three, Four, Five});
        C.setProgrammerPreferences(new Programmer[] {Five, Three, Two, One, Four});
        D.setProgrammerPreferences(new Programmer[] {One, Three ,Two, Four, Five});
        E.setProgrammerPreferences(new Programmer[] {Two, Three, Five, Four, One});

        One.setCompanyPreference(new Company[] {E, A, D, B, C});
        Two.setCompanyPreference(new Company[] {D, E, B, A, C});
        Three.setCompanyPreference(new Company[] {D, B, C, E, A});
        Four.setCompanyPreference(new Company[] {C, B, D, A, E});
        Five.setCompanyPreference(new Company[] {A, D, B, C, E});

        Company[] companyArray = new Company[] {A, B, C, D, E};
        Programmer[] programmerArray = new Programmer[] {One, Two, Three, Four, Five};

        Bin[] satisfactoryMatches = run.makeMatches(companyArray, programmerArray);

        for(int i = 0; i < satisfactoryMatches.length; i++) {
            System.out.println(satisfactoryMatches[i].getCompany().getName() + " and " + satisfactoryMatches[i].getProgrammer().getName());
        }
    }
}
