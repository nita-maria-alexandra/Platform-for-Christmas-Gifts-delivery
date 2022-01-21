package data;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class ChildInputData {
        private final Integer id;

        private final String lastName;

        private final String firstName;

        private final String city;

        private Double niceScore;

        private Integer age;

        private LinkedList<String> giftsPreferences;

        private double averageScore;

        private List<Double> niceScoreHistory = new ArrayList<>();

        private double assignedBudget;

        private List<GiftInputData> receivedGifts = new ArrayList<>();

        private final Double niceScoreBonus;

        private String elf;

        public ChildInputData() {
            this.id = 0;
            this.lastName = null;
            this.firstName = null;
            this.city = null;
            this.niceScoreBonus = null;
            this.elf = null;
        }

        public ChildInputData(final ChildInputData childInputData) {
            this.id = childInputData.getId();
            this.age = childInputData.getAge();
            this.lastName = childInputData.getLastName();
            this.firstName = childInputData.getFirstName();
            this.city = childInputData.getCity();
            this.niceScore = childInputData.getNiceScore();
            this.giftsPreferences = new java.util.LinkedList<>();
            this.giftsPreferences.addAll(childInputData.getGiftsPreferences());
            this.niceScoreHistory.addAll(childInputData.getNiceScoreHistory());
            this.assignedBudget = childInputData.getAssignedBudget();
            for (data.GiftInputData gift: childInputData.getReceivedGifts()) {
                this.receivedGifts.add(new GiftInputData(gift));
            }
            this.averageScore = childInputData.getAverageScore();
            niceScoreBonus = null;
        }

        /**
         * @return returneaza @id
         */
        public Integer getId() {
            return id;
        }

        /**
         * @return returneaza @lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * @return returneaza @firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * @return returneaza @age
         */
        public Integer getAge() {
            return age;
        }

        /**
         * @return returneaza @city
         */
        public String getCity() {
            return city;
        }


        /**
         * @param age returneaza @age
         */
        public void setAge(final Integer age) {
            this.age = age;
        }

        /**
         * @return returneaza @niceScore
         */
        @com.fasterxml.jackson.annotation.JsonIgnore
        public double getNiceScore() {
            return niceScore;
        }

        /**
         * setter
         */
        @com.fasterxml.jackson.annotation.JsonProperty
        public void setNiceScore(final double niceScore) {
            this.niceScore = niceScore;
        }

        /**
         * @return returneaza @giftsPreferences
         */
        public java.util.LinkedList<String> getGiftsPreferences() {
            return giftsPreferences;
        }

        /**
         * setter
         */
        public void setGiftsPreferences(final java.util.LinkedList<String> giftsPreference) {
            this.giftsPreferences = giftsPreference;
        }

        /**
         * @return returneaza @niceScoreHistory
         */
        public java.util.List<Double> getNiceScoreHistory() {
            return niceScoreHistory;
        }

        /**
         * @return returneaza @averageScore
         */
        public double getAverageScore() {
            return averageScore;
        }

        /**
         * setter
         */
        public void setAverageScore(final double averageScore) {
            this.averageScore = averageScore;
        }

        /**
         * @return returneaza @assignedBudget
         */
        public double getAssignedBudget() {
            return assignedBudget;
        }

        /**
         * setter
         */
        public void setAssignedBudget(final double budget) {
            this.assignedBudget = budget;
        }

        /**
         * @return returneaza @receivedGifts
         */
        public java.util.List<GiftInputData> getReceivedGifts() {
            return receivedGifts;
        }

        /**
         * setter
         */
        public void setReceivedGifts(final java.util.List<GiftInputData> receivedGifts) {
            this.receivedGifts = receivedGifts;
        }

        /**
         *
         * @return ..
         */
        public Double getNiceScoreBonus() {
                return niceScoreBonus;
        }

        /**
         *
         * @return ...
         */
        public String getElf() {
                return elf;
        }

        /**
         * 
         * @param elf ...
         */
        public void setElf(String elf) {
                this.elf = elf;
            }

    /**
         * Suprascrie metoda toString()
         */
        @Override
        public String toString() {
            return "ChildInputData{"
                    + "id=" + id
                    + ", lastName='" + lastName + '\''
                    + ", firstName='" + firstName + '\''
                    + ", city='" + city + '\''
                    + ", niceScore=" + niceScore
                    + ", age=" + age
                    + ", giftsPreferences=" + giftsPreferences
                    + ", averageScore=" + averageScore
                    + ", niceScoreHistory=" + niceScoreHistory
                    + ", assignedBudget=" + assignedBudget
                    + ", receivedGifts=" + receivedGifts
                    + '}';
        }
}
