/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epicest.reusables.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mjspr
 */
public class Configuration extends Properties {

 protected String ioPath = "configuration.properties";

 protected File ioFile = new File(ioPath);

 protected FileInputStream fis;

 protected FileOutputStream fos;

 public Configuration() {
  Logger.getLogger(Configuration.class.getName()).setLevel(Level.WARNING);
  this.setProperty("appname", "Application");
 }

 public Configuration(String ioPath) {
  Logger.getLogger(Configuration.class.getName()).setLevel(Level.WARNING);
  this.ioPath = ioPath;
  this.setProperty("appname", "Application");
 }

 public void setIOPath(String ioPath) {
  this.ioPath = ioPath;
  ioFile = new File(ioPath);
 }

 public void loadIO() {
  try {
   if (ioFile.exists()) {
    fis = new FileInputStream(ioFile);
   } else {
    ioFile.createNewFile();
    fos = new FileOutputStream(ioFile);
    this.store(fos, ioPath);
    fis = new FileInputStream(ioFile);
   }
   this.load(fis);
  } catch (FileNotFoundException fnfex) {
   Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, fnfex);
  } catch (IOException ioex) {
   Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ioex);
  }
 }

 public void saveIO() {
  try {
   if (ioFile.exists()) {
    fos = new FileOutputStream(ioFile);
   } else {
    ioFile.createNewFile();
    fos = new FileOutputStream(ioFile);
    this.store(fos, ioPath);
    fis = new FileInputStream(ioFile);
   }
   this.store(fos, ioPath);
  } catch (FileNotFoundException fnfex) {
   Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, fnfex);
  } catch (IOException ioex) {
   Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ioex);
  }
 }

}
