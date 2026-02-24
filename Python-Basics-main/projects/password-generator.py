import random
import string

print("Welcome to IronLock Password Generator")
l = int(input("Enter the length(atleast 6) of password you want to generate: "))

lowercase_letters = string.ascii_lowercase
uppercase_letters = string.ascii_uppercase
digits = string.digits
special_characters = string.punctuation
all_characters = lowercase_letters + uppercase_letters + digits + special_characters

uc = random.choice(uppercase_letters)
lc = random.choice(lowercase_letters)
dig = random.choice(digits)
sym = random.choice(special_characters)

password = uc + lc + dig + sym
for i in range(l - 4):
    password += random.choice(all_characters)


char_list = list(password)  # Convert the string to a list
random.shuffle(char_list)   # Shuffle the list
password = ''.join(char_list)  # Convert the shuffled list back to a string

print(password)