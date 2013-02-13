/*
 * Copyright 2013 Ivan Masmitjà
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.comapctsys.androlib.samples;

import java.util.ArrayList;

public class Car {
    private String mLicense;
    private String mModel;
    private int mYear;

    public static Car create(String license, String model, int year) {
        Car c = new Car();
        c.setLicense(license);
        c.setModel(model);
        c.setYear(year);

        return c;
    }

    public static ArrayList<Car> createDemo() {
        ArrayList<Car> list = new ArrayList<Car>();
        list.add(Car.create("X-2545-HGF", "Seat Ibiza", 2003));
        list.add(Car.create("F-2345-BAR", "Toyota Verso", 2010));
        list.add(Car.create("V-2234-FRE", "volkswagen Polo", 2001));
        return list;
    }

    public Car() {
    }

    public String getLicense() {
        return mLicense;
    }

    public void setLicense(String license) {
        this.mLicense = license;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }
}
