///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package edu.wpi.first.wpilibj.templates;
////
//import edu.wpi.first.wpilibj.templates.commands.Dance;
////
/////**
//// *
//// * @author Team3946 GeForce
//// */
//public class CodeMonitor {
//     private static final String[] code = 
//        {"UP", "UP", "DOWN", "DOWN", "LEFT", "RIGHT", "LEFT", "RIGHT", "B", "A"};
//    static private int currentNode = 0;
//    static Dance dance;
//    //Call checkKonami(key) whenever a key is pressed
//
//    /**
//     *
//     * @param button
//     */
//        public static void CodeButtonUpdate(String button){
//        //ALL Inputs = DANCE!
//        if(button == null ? code[currentNode] == null : button.equals(code[currentNode])){
//            currentNode++;
//        } else {
//            currentNode = 0;
//        }
//        if(currentNode == code.length){
//            dance = new Dance(10.0);
//            currentNode = 0;
//        }
//    }
//}
