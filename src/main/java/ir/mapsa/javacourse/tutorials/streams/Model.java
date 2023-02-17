package ir.mapsa.javacourse.tutorials.streams;

public class Model {
    private String rowNumber;
    private String customerId;
    private String surname;
    private String creditScore;
    private String geography;
    private String gender;
    private String age;
    private String tenure;
    private String beginningBalance;
    private String balance;
    private String numOfProducts;
    private String hasCrCard;
    private String isActiveMember;
    private Double estimatedSalary;
    private String exited;
    private String currentLoanAmount;

    public Model(String rowNumber, String customerId, String surname, String creditScore, String geography, String gender, String age, String tenure, String beginningBalance, String balance, String numOfProducts, String hasCrCard, String isActiveMember, String estimatedSalary, String exited, String currentLoanAmount) {
        this.rowNumber = rowNumber;
        this.customerId = customerId;
        this.surname = surname;
        this.creditScore = creditScore;
        this.geography = geography;
        this.gender = gender;
        this.age = age;
        this.tenure = tenure;
        this.beginningBalance = beginningBalance;
        this.balance = balance;
        this.numOfProducts = numOfProducts;
        this.hasCrCard = hasCrCard;
        this.isActiveMember = isActiveMember;
        this.estimatedSalary = Double.parseDouble(estimatedSalary);
        this.exited = exited;
        this.currentLoanAmount = currentLoanAmount;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(String beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getNumOfProducts() {
        return numOfProducts;
    }

    public void setNumOfProducts(String numOfProducts) {
        this.numOfProducts = numOfProducts;
    }

    public String getHasCrCard() {
        return hasCrCard;
    }

    public void setHasCrCard(String hasCrCard) {
        this.hasCrCard = hasCrCard;
    }

    public String getIsActiveMember() {
        return isActiveMember;
    }

    public void setIsActiveMember(String isActiveMember) {
        this.isActiveMember = isActiveMember;
    }

    public Double getEstimatedSalary() {
        return estimatedSalary;
    }

    public void setEstimatedSalary(Double estimatedSalary) {
        this.estimatedSalary = estimatedSalary;
    }

    public String getExited() {
        return exited;
    }

    public void setExited(String exited) {
        this.exited = exited;
    }

    public String getCurrentLoanAmount() {
        return currentLoanAmount;
    }

    public void setCurrentLoanAmount(String currentLoanAmount) {
        this.currentLoanAmount = currentLoanAmount;
    }

    @Override
    public String toString() {
        return "Model{" +
                "rowNumber='" + rowNumber + '\'' +
                ", customerId='" + customerId + '\'' +
                ", surname='" + surname + '\'' +
                ", creditScore='" + creditScore + '\'' +
                ", geography='" + geography + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", tenure='" + tenure + '\'' +
                ", beginningBalance='" + beginningBalance + '\'' +
                ", balance='" + balance + '\'' +
                ", numOfProducts='" + numOfProducts + '\'' +
                ", hasCrCard='" + hasCrCard + '\'' +
                ", isActiveMember='" + isActiveMember + '\'' +
                ", estimatedSalary='" + estimatedSalary + '\'' +
                ", exited='" + exited + '\'' +
                ", currentLoanAmount='" + currentLoanAmount + '\'' +
                '}';
    }
}
