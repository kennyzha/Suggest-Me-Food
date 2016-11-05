package organizing;

import java.util.ArrayList;

public class Recipe {
	String name;
	String imageURL; 
	ArrayList<String> ingredients;
	ArrayList<String> nutrition;
	ArrayList<String> fats;
	ArrayList<String> carbs;
	int calories;
	
	public Recipe(){
		name = "NONE";
		ingredients = new ArrayList<String>();
		imageURL = "NONE";
		nutrition = new ArrayList<String>();
		calories = 0;
		fats = 	new ArrayList<String>();
		carbs = new ArrayList<String>();
	}
	
	Recipe(String recipeName, String recipeImageURL, ArrayList<String> listOfIngredients, ArrayList<String> listOfNutritionFacts, int numOfCalories){
		name = recipeName;
		imageURL = recipeImageURL;
		ingredients = listOfIngredients;
		nutrition = listOfNutritionFacts;
		calories = numOfCalories;
		
	}
	
	/**
	 * set the image URL for this recipie
	 */
	public void setImageURL(String url){
		imageURL = url;
	}
	/**
	 * returns the url of this image
	 * @return url of image for this recipie
	 */
	public String getImageURL(){
		return imageURL;
	}
	/**
	 * @return - name of this recipie
	 */
	public String getName(){
		return name;
	}
	/**
	 * set a new name for the recipie
	 * @param newName - new name of recipie
	 */
	public void setName(String newName){
		name = newName;
	}
	/**
	 * set the ingredients of the recipie
	 * @param ingreds -  array list of ingredients to add
	 */
	public void setIngredients(ArrayList<String> ingreds){
		ingredients = ingreds;
	}
	/**
	 * get ingredient by a specified index in the list of ingredients
	 * @param index -index of ingredient in list of ingredients
	 * @return the string representation of ingredient
	 */
	public String getIngredient(int index){
		return ingredients.get(index);
	}
	/**
	 * adds single ingredient to the list of ingredients
	 * @param ingredient to add
	 */
	public void addIngredient(String ingredient){
		ingredients.add(ingredient);
	}
	/**
	 * @return the array list of ingredients
	 */
	public ArrayList<String> getIngredients(){
		return ingredients;
	}
	/**
	 * returns if a recipie contains an ingredient (food)
	 * @return boolean
	 */
	public boolean containsIngredient(String food){
		return ingredients.contains(food);
		
	}
	/**
	 * @return array list of nutrition elements for recipe
	 */
	public ArrayList<String> getNutrition(){
		return nutrition;
	}
	/**
	 * sets the list of nutrion facts aside from fats and carbs
	 * @param info - list of isolated nutrition facts
	 */
	public void setNutrition(ArrayList<String> info){
		nutrition = info;
	}
	/**
	 * adds a nutrient to the list of isolated nutrients
	 * @param info -  the string of that nutrient
	 */
	public void addNutrient(String info){
		nutrition.add(info);
	}
	/**
	 * returns the calorie count of recipe
	 * @return cal count
	 */
	public int getCalorieCount(){
		return calories;
	}
	/**
	 * sets the calories of the recipe
	 * @param cals
	 */
	public void setCalories(int cals){
		calories = cals;
	}
	
	public ArrayList<String> getFatsList(){return fats;}
	public boolean containsFat(String fat){return fats.contains(fat);}
	public void setFatList(ArrayList<String> fatsList){fats = fatsList;}
	public void addFat(String fat){fats.add(fat);}
	
	public ArrayList<String> getCarbsList(){return carbs;}
	public boolean containsCarb(String carb){return carbs.contains(carbs);}
	public void setCarbsList(ArrayList<String> carbsList){carbs = carbsList;}
	public void addCarb(String carb){carbs.add(carb);}
	
	public String toString(){
		String returnMe = "Name: " + name + '\n' +
				"Img URL: " + imageURL + '\n' +
				"Calories: " + calories + '\n' +
				"Ingredients: " + ingredients.toString() + '\n' +
				"Fats: " + fats.toString() + '\n' +
				"Carbs: " + carbs.toString() + '\n' +
				"Nutrition Facts: " + nutrition.toString();						
		return returnMe;
	}
}
