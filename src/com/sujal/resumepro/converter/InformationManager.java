package com.sujal.resumepro.converter;

import java.util.ArrayList;
import java.util.Vector;

public class InformationManager {
	public static String name;
	public static String address;
	public static String phone;
	public static String email;
	public static String website;
	public static ArrayList<EducationData> educationDatas;
	public static ArrayList<String> skills;
	public static ArrayList<ExperienceData> experienceDatas;
	
	public static void addEducationData(EducationData data) {
		educationDatas.add(data);
	}
	
	public static void addSkills(String skill) {
		skills.add(skill);
	}
	
	public static void addExperienceData(ExperienceData data) {
		experienceDatas.add(data);
	}
}
