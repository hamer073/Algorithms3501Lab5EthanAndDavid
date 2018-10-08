public class Test {
    public static void main(String[] args){
        test1();
        System.out.println();
        //test2();

        // Test to check satisfactory pairings
        /*
        for(int i = 0; i < satisfactoryMatches.length; i++){
            for(int j = i+1; j < satisfactoryMatches.length; j++){
                System.out.println("Are the pairings satisfactory? " + Boolean.toString(!run.checkNotSatisfactory(satisfactoryMatches[i], satisfactoryMatches[j])));
            }
        }
        */


    }

    private static void test1(){
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

        for(Bin pairing :  satisfactoryMatches) {
            System.out.println(pairing.getCompany().getName() + " and " + pairing.getProgrammer().getName());
        }
    }

    private static void test2(){

        MakeSatisfactory run = new MakeSatisfactory();

        Company A = new Company("A");
        Company B = new Company("B");
        Company C = new Company("C");

        Programmer One = new Programmer("One");
        Programmer Two = new Programmer("Two");
        Programmer Three = new Programmer("Three");

        A.setProgrammerPreferences(new Programmer[] {Two,Three,One});
        B.setProgrammerPreferences(new Programmer[] {One,Two,Three});
        C.setProgrammerPreferences(new Programmer[] {One,Three,Two});

        One.setCompanyPreference(new Company[] {A,C,B});
        Two.setCompanyPreference(new Company[] {B,C,A});
        Three.setCompanyPreference(new Company[] {C,A,B});

        Company[] companyArray = new Company[] {A, B, C};
        Programmer[] programmerArray = new Programmer[] {One, Two, Three};

        Bin[] satisfactoryMatches = run.makeMatches(companyArray, programmerArray);

        for(Bin pairing : satisfactoryMatches) {
            System.out.println(pairing.getCompany().getName() + " and " + pairing.getProgrammer().getName());
        }
    }
}
