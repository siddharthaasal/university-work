import requests
from bs4 import BeautifulSoup

# Send an HTTP request to the website
url = 'https://www.literotica.com/s/supra-blackmail'
response = requests.get(url)

if response.status_code == 200:
    # Parse the HTML content
    soup = BeautifulSoup(response.text, 'html.parser')
    
    # Find the specific class or element
    target_element = soup.find('div', class_='aa_ht')

    if target_element:
        # Extract text from the element
        story_text = target_element.get_text()

        # Save the text to a file
        with open('story.txt', 'w', encoding='utf-8') as file:
            file.write(story_text)
    else:
        print('Target element not found on the page.')
else:
    print('Failed to retrieve the web page.')
