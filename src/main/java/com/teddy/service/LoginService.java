package com.teddy.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Data
@NoArgsConstructor
public class LoginService {

    boolean checkPassword(String userName, String password){

    }
}
