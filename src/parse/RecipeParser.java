package parse;

import java.io.*;
import organizing.Recipe;

public class RecipeParser {
	private String recipeFileLoc;
	private Recipe recipe;
	
	public RecipeParser(String recipieFileLocation){
		recipeFileLoc = recipieFileLocation;
		recipe = new Recipe();
		
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(recipeFileLoc));

			while ((sCurrentLine = br.readLine()) != null) {
//System.out.println("Line is: " + sCurrentLine);
				parseLine(sCurrentLine);
			}
System.out.println(recipe.toString());

		} catch (IOException e) {
			System.out.println("RECIPE TXT FILE NOT FOUND, Please Try Again");
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public void parseLine(String curLine) {
		// TODO Auto-generated method stub
		String lineID = curLine.split(":")[0];
		String lineVAL = curLine.split(": ")[1];
System.out.println("lineID: " + lineID);
System.out.println("lineVAL: " + lineVAL);
		
		switch(lineID){
			case "name":
				String theName = lineVAL;
				recipe.setName(theName);
				break;
			case "img_url":
				String url = lineVAL;
				recipe.setImageURL(url);
				break;
			case "ingredient":
				String ingred = lineVAL;
				recipe.addIngredient(lineVAL);
				break;
			case "calories":
				String cals = lineVAL;
				recipe.setCalories(Integer.parseInt(lineVAL));
				break;
			case "nutrition":
				String nutrient = lineVAL; 
				recipe.addNutrient(lineVAL);
				break;
			case "nutritionF":
				String fat = lineVAL;
				recipe.addFat(lineVAL);
				break;
			case "nutritionC":
				String carb = lineVAL;
				recipe.addCarb(carb);
				break;
		}
		
	}	
	
}
