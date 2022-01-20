package baitap;

public class CosmeticManagement extends AbstractManagement<Cosmetic> {

    @Override
    public String getFileName() {
        return "mypham.txt";
    }

    @Override
    public String getTempFileName() {
        return "myphamTemp.txt";
    }

    @Override
    public Cosmetic getObjectFromFile(String[] strings) {
        Cosmetic cosmetic = new Cosmetic();
        cosmetic.setId(strings[0]);
        cosmetic.setCosmeticName(strings[1]);
        cosmetic.setCosmeticType(strings[2]);
        cosmetic.setMadeIn(strings[3]);
        cosmetic.setInUnitPrice(Double.parseDouble(strings[4]));
        cosmetic.setOutUnitPrice(Double.parseDouble(strings[5]));
        cosmetic.setDateIn(strings[6]);
        cosmetic.setInAmount(Integer.parseInt(strings[7]));
        cosmetic.setDateOut(strings[8]);
        cosmetic.setOutAmount(Integer.parseInt(strings[9]));
        cosmetic.setTotalInAmount(Integer.parseInt(strings[10]));
        cosmetic.setTotalOutAmount(Integer.parseInt(strings[11]));
        cosmetic.setTotalAmount(Integer.parseInt(strings[12]));
        return cosmetic;
    }

    @Override
    protected String generateObjectAsString(Cosmetic cosmetic) {
        return null;
    }

    private void console() {

    }
}
