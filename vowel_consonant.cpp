# include <iostream>
# include <string>


int main(int argc, char const* argv[]){
	// variable declaration
	std::string text;
	char t2;
	std::pair<int, int> count = std::pair(0, 0); // stores the total count of vowels and consonants
	
	// asking user for text
	std::cout << "Enter your text: ";
	std::getline(std::cin, text);
	
	// iterating through all of the chars in string
	for(auto t : text){
		// checking if text is a random character, not an alphabet
		if(t < 65 || (t > 90 && t < 97) || t > 122) continue;
		
		// storing the char in another variable and checking if it is small, being small is made capital
		t2 = t;
		if(t2 > 90) t2 -= 32;
		
		// checking if the char is a capital vowel
		if(t2 == 65 || t2 == 69 || t2 == 73 || t2 == 79 || t2 == 85)count.first++;
		else count.second++;
	}
	
	// printing the data
	std::cout << "The total number of vowels are: " << count.first << '\n';
	std::cout << "The total number of consonants are: " << count.second << '\n';
}
