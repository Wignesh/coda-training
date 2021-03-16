package ga.veee.day7;

public class Corruption {
    public static void main(String[] args) {
        Corporation corporation = new Corporation();
        Hospital hospital = new Hospital();
        Police police = new Police();
        FoodSafety foodSafety = new FoodSafety();

        SevaCorporationQuery sevaCorporationQuery = new SevaCorporationQuery(corporation, hospital, police, foodSafety);
        SevaHospitalQuery sevaHospitalQuery = new SevaHospitalQuery(corporation, hospital, police, foodSafety);
        SevaPoliceQuery sevaPoliceQuery = new SevaPoliceQuery(corporation, hospital, police, foodSafety);
        SevaFoodSafetyQuery sevaFoodSafetyQuery = new SevaFoodSafetyQuery(corporation, hospital, police, foodSafety);

        Government myGovernment = new Government();

        myGovernment.setQuery(1, sevaCorporationQuery);
        myGovernment.setQuery(2, sevaHospitalQuery);
        myGovernment.setQuery(3, sevaPoliceQuery);
        myGovernment.setQuery(4, sevaFoodSafetyQuery);
        myGovernment.executeQuery(1);
    }
}

class Government {
    SevaDepartment[] quries = new SevaDepartment[5];

    public Government() {
        for (int i = 0; i < 5; i++) {
            quries[i] = new DummySeva();
        }
    }

    public void setQuery(int slot, SevaDepartment department) {
        this.quries[slot] = department;
    }

    public void executeQuery(int slot) {
        this.quries[slot].resolve();
    }

}

class DummySeva extends SevaDepartment {

    @Override
    public void resolve() {
        System.out.println("I am dummy yet to be operational...");

    }
}

abstract class SevaDepartment {

    public SevaDepartment(Corporation corporation, Hospital hospital, Police police, FoodSafety foodSafety) {
        this.corporation = corporation;
        this.hospital = hospital;
        this.police = police;
        this.foodSafety = foodSafety;
    }

    public final Corporation getCorporation() {
        return corporation;
    }

    public final Hospital getHospital() {
        return hospital;
    }

    public final Police getPolice() {
        return police;
    }

    public final FoodSafety getFoodSafety() {
        return foodSafety;
    }

    private Corporation corporation;
    private Hospital hospital;
    private Police police;
    private FoodSafety foodSafety;

    public SevaDepartment() {

    }

    public abstract void resolve();

}

class SevaCorporationQuery extends SevaDepartment {
    public SevaCorporationQuery(Corporation corporation, Hospital hospital, Police police, FoodSafety foodSafety) {
        super(corporation, hospital, police, foodSafety);
    }

    @Override
    public void resolve() {
        System.out.println("Resolves issues with Corporation Department");
        getCorporation().resolve();
    }
}

class SevaHospitalQuery extends SevaDepartment {
    public SevaHospitalQuery(Corporation corporation, Hospital hospital, Police police, FoodSafety foodSafety) {
        super(corporation, hospital, police, foodSafety);
    }

    @Override
    public void resolve() {
        System.out.println("Resolves issues with Hospital Department");
        getHospital().resolve();
    }
}

class SevaPoliceQuery extends SevaDepartment {
    public SevaPoliceQuery(Corporation corporation, Hospital hospital, Police police, FoodSafety foodSafety) {
        super(corporation, hospital, police, foodSafety);
    }

    @Override
    public void resolve() {
        System.out.println("Resolves issues with Police Department");
        getPolice().resolve();
    }
}

class SevaFoodSafetyQuery extends SevaDepartment {
    public SevaFoodSafetyQuery(Corporation corporation, Hospital hospital, Police police, FoodSafety foodSafety) {
        super(corporation, hospital, police, foodSafety);
    }

    @Override
    public void resolve() {
        System.out.println("Resolves issues with FoodSafety Department");
        getFoodSafety().resolve();
    }
}

class Corporation {
    public void resolve() {
        System.out.println("Resolving Corporation Issues............");
        System.out.println("Issues resolved");
    }

}

class Hospital {
    public void resolve() {
        System.out.println("Resolving Hospital Issues............");
        System.out.println("Issues resolved");
    }
}

class Police {
    public void resolve() {
        System.out.println("Resolving Police Issues............");
        System.out.println("Issues resolved");
    }
}

class FoodSafety {
    public void resolve() {
        System.out.println("Resolving FoodSafety Issues............");
        System.out.println("Issues resolved");
    }
}