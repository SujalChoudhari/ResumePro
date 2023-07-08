package com.sujal.resumepro.converter;

import java.util.ArrayList;
import java.util.Vector;

//public record EducationData(
//		String instituteName,
//		String from,
//		String to,
//		String certificate
//		) {
//
//}

//public record ExperienceData(
//		String institute,
//		String from,
//		String to,
//		String designation
//		) {
//
//}


public class CollectedData {
	public static String name;
	public static String address;
	public static String phone;
	public static String email;
	public static String website;
	public static ArrayList<EducationData> educationDatas =new ArrayList<EducationData>();
	public static ArrayList<String> skills =new ArrayList<String>();
	public static ArrayList<ExperienceData> experienceDatas = new ArrayList<ExperienceData>();
	
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
