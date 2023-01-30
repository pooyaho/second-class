package ir.mapsa.javacourse.session7;

public enum Bank {
    PARSIAN(6221),MELLAT(6104),MELLI(6037);

    private final int bankCode;

    Bank(int value) {
        this.bankCode = value;
    }

    public int getBankCode() {
        return bankCode;
    }

    public static Bank from(int code) {
        for (Bank value : Bank.values()) {
            if (value.getBankCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }

}

class TestEnum{
    public static void main(String[] args) {
        int bankCode;

//        switch (Bank.from(bankCode)) {
//            case MELLI:
//            case MELLAT:
//            case PARSIAN:
//
//        }
    }
}