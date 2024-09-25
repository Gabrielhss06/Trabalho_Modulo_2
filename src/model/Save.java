package model;

public class Save {
    private int idSave;
    private int idCenaAtual;

    public Save(int idSave, int idCenaAtual) {
        this.idSave = idSave;
        this.idCenaAtual = idCenaAtual;
    }

    public int getIdSave() {
        return idSave;
    }

    public void setIdSave(int idSave) {
        this.idSave = idSave;
    }

    public int getIdCenaAtual() {
        return idCenaAtual;
    }

    public void setIdCenaAtual(int idCenaAtual) {
        this.idCenaAtual = idCenaAtual;
    }
}
