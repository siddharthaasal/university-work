def count_word_frequency(words):
    # TODO
    my_dict = {}
    for i in words:
        if not i in my_dict:
            my_dict[i] = 1
        else:
            my_dict[i] = my_dict[i] + 1
    
    return my_dict

words = ['apple', 'orange', 'banana', 'apple', 'orange', 'apple'] 
print(count_word_frequency(words)) 

# def count_word_frequency(words):
#     word_count = {}
#     for word in words:
#         word_count[word] = word_count.get(word, 0) + 1
#     return word_count