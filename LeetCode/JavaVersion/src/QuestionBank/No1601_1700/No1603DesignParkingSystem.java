package QuestionBank.No1601_1700;

public class No1603DesignParkingSystem {
    private int big=0,medium=0,small=0;

    public No1603DesignParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;
    }

    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                if(big>0){
                    big--;
                    return true;
                }
                break;
            case 2:
                if(medium>0){
                    medium--;
                    return true;
                }
                break;
            case 3:
                if(small>0){
                    small--;
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */