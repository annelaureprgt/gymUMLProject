package fr.efrei.factory;

import fr.efrei.domain.Member;
import fr.efrei.domain.Membership;
import fr.efrei.util.Helper;

import java.time.LocalDate;

public class MemberFactory {

    public static Member buildMember(int id, String firstName, String lastName, int age, String email, String phoneNumber, String membershipStatus, String paymentRate, LocalDate startDate, LocalDate endDate) {
        Membership membership = MembershipFactory.buildMembership(membershipStatus, paymentRate, startDate, endDate);
        if (membership == null) {
            System.out.println("Membership is incorrect");
            return null;
        }
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(String.valueOf(age)) || Helper.isNullOrEmpty(String.valueOf(id)) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber)) {
            System.out.println("Empty member data");
            return null;
        }

        if (age < 18) {
            System.out.println("The age is below 18");
            return null;
        }

        return new Member.Builder().setMemberID(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setMembership(membership)
                .build();
    }

    public static Member buildMember(String firstName, String lastName, int age, String email, String phoneNumber, String membershipStatus, String paymentRate, LocalDate startDate, LocalDate endDate) {
        Membership membership = MembershipFactory.buildMembership(membershipStatus, paymentRate, startDate, endDate);
        if (membership == null || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(String.valueOf(age)) || age > 0 || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        int id = Helper.generateId();

        return new Member.Builder().setMemberID(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(age)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setMembership(membership)
                .build();
    }
}
