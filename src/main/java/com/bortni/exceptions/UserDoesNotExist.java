package com.bortni.exceptions;

public class UserDoesNotExist extends Exception{

        public UserDoesNotExist(){
            super();
        }

        public UserDoesNotExist(String message){
            super(message);
        }

}
