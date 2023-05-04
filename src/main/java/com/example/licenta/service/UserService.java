package com.example.licenta.service;

import com.example.licenta.model.Result;
import com.example.licenta.model.User;
import com.example.licenta.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class UserService{
    @Resource
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findUser(User user) {
        User userObj = userRepository.findUserByEmail(user.getEmail());
        if (userObj != null) {
            userObj = userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
            if (userObj == null) {
                return null;
            }
        } else {
            user = userRepository.save(user);
        }
        return user;
    }

    public User updateProgress(String email, String nameChapter) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            String progress = user.getProgress();
            if (progress == null) {
                progress = "";
            }
            progress = progress + nameChapter + ";";
            user.setProgress(progress);
            user = userRepository.save(user);
        }
        return user;
    }
    public String getUserProgress (String email) {
        System.out.println(email);
        String progress = userRepository.findUserByEmail(email).getProgress();
        System.out.println(progress);
        String[] arr = progress.split(";");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
        return list.get(list.size()-1);
    }

    public User updateResults(String email, String nameChapter, float score) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            String results = user.getResults();
            if (results == null) {
                results = "";
            }
            results = results + nameChapter + ":" + score + ";";
            user.setResults(results);
            user = userRepository.save(user);
        }
        return user;
    }

    public ArrayList<Result> getUserResults(String email) {
        System.out.println(email);
        String results = userRepository.findUserByEmail(email).getResults();
        System.out.println(results);
        String[] arr = results.split(";");

        ArrayList<Result> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));

        for (int i = 0; i < list.size(); i++) {
            String[] splitResult = list.get(i).split(":");
            Result result = new Result(splitResult[0], (long) Double.parseDouble(splitResult[1]));
            res.add(result);
        }
        return res;
}

   public String getUserResult(String email,String chapter) {

       System.out.println(email);
       String results = userRepository.findUserByEmail(email).getResults();
       System.out.println(results);
       String[] arr = results.split(";");

       ArrayList<Result> res = new ArrayList<>();
       ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));

       for (int i = 0; i < list.size(); i++) {
           String[] splitResult = list.get(i).split(":");
           if(splitResult[0].equals(chapter))
           {
               return splitResult[1];
           }

       }
      return "0";
   }


}