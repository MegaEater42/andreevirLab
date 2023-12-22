package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.User;

public interface UserService {
    User create(User user);
    int calculateCreditRating(User user);
}
