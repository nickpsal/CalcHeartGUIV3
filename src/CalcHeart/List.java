package CalcHeart;

public class List {
    private int id;
    private String onoma;
    private String eponimo;
    private int etos;
    private int ilikia;
    private double min;
    private double max;

    public List(int id, String onoma, String eponimo, int etos, int ilikia, double min, double max) {
        this.id = id;
        this.onoma = onoma;
        this.eponimo = eponimo;
        this.etos = etos;
        this.ilikia = ilikia;
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        String text = "ID : " + id + " ";
        text += "ΟΝΟΜΑ : " + onoma + " ";
        text += "ΕΠΩΝΥΜΟ : " + eponimo + " ";
        text += "ΕΤΟΣ ΓΕΝΝΗΣΗΣ :" + etos + " ";
        text += "ΗΛΙΚΙΑ : " + ilikia + " ";
        text += "ΚΑΙ ΘΑ ΠΡΕΠΕΙ ΝΑ ΕΧΕΙ ΕΛΑΧΙΣΤΟ ΚΑΡΔΙΑΚΟ ΠΑΛΜΟ " + min + "ΚΑΙ ΜΕΓΙΣΤΟ ΚΑΡΔΙΑΚΟ ΠΑΛΜΟ " + max;
        return text;
    }
}

