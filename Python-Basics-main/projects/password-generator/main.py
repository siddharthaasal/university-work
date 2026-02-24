import random
import string

def generate_password(length):
    # Define the characters to choose from for each character type
    lowercase_letters = string.ascii_lowercase
    uppercase_letters = string.ascii_uppercase
    digits = string.digits
    special_characters = string.punctuation

    # Combine all character types
    all_characters = lowercase_letters + uppercase_letters + digits + special_characters

    # Ensure that the generated password contains at least one character from each type
    password = random.choice(lowercase_letters) + random.choice(uppercase_letters) + random.choice(digits) + random.choice(special_characters)

    # Generate the remaining characters of the password
    for _ in range(length - 4):
        password += random.choice(all_characters)

    # Shuffle the password to ensure randomness
    password_list = list(password)
    random.shuffle(password_list)
    password = ''.join(password_list)

    return password

# Usage example: generate a password of length 12
password = generate_password(12)
print(password)
