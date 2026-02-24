import random
user_choice = int(input("Type 0 for Rock, 1 for Paper, and 2 for scissors: "))
computer_choice = random.randint(0,2)
list = ["Rock", "Paper", "Scissors"]
print("You chose " + list[user_choice])
print("Computer chose " + list[computer_choice])
if user_choice>2 or user_choice<0:
    print("Invalid choice")
elif(user_choice-computer_choice == -1 or user_choice-computer_choice == 2):
    print("Computer Won")
elif user_choice-computer_choice==0:
    print("It is a TIE!")
else:
    print("You WON!")