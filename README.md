# Lazo Nikoloski 213018

![CFG drawio](https://github.com/213018/SI_2023_lab2_213018/assets/129883425/911c7aa8-c4da-4b6c-9acb-233d42e5fb14)

Цикломатската комплексност изнесува 35 - 26 + 2 = 11. Резултатот се добива со примена на формулата E-N+2, каде Е претставува бројот на ребра и N претставува бројот на јазли. 

## Every Branch
1. UserIsNull
1. EmailIsNull
1. PasswordIsNull
1. PasswordIsValid
1. PasswordHasEmptySpace
1. PasswordWithoutSpecialCharacters
1. PasswordAndEmailNull

## Multiple condition 
if (user==null || user.getPassword()==null || user.getEmail()==null)

1. UserIsNull - доколку user==null => целиот израз е точен
1. UserIsValidPasswordIsNull -  доколку user!=null и user.getPassword()==null => целиот израз е точен
1. UserIsValidPasswordIsValidEmailIsNull - доколку user!= null, user.getPassword()!=null и user.getEmail()==null => целиот израз е точен
1. AllConditionsAreNotValid - доколку user==null, user.getPassword()==null и user.getEmail()==null => целиот израз е неточен
