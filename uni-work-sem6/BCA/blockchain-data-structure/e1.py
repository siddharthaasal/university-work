import hashlib
import datetime

class Block:
    def __init__(self, index, timestamp, transactions, previous_hash):
        self.index = index
        self.timestamp = timestamp
        self.transactions = transactions
        self.previous_hash = previous_hash
        self.nonce = 0
        self.hash = self.calculate_hash()

    def calculate_hash(self):
        if self.previous_hash == '0':
            return None
        else:    
            block_string = str(self.index) + str(self.timestamp) + str(self.transactions) + str(self.previous_hash) + str(self.nonce)
            return hashlib.sha256(block_string.encode()).hexdigest()    

class Blockchain:
    def __init__(self):
        self.chain = [self.create_genesis_block()]

    def create_genesis_block(self):
        return Block(0, datetime.datetime.now(), "Genesis Block", "0")

    def add_block(self, new_block):
        new_block.previous_hash = self.chain[-1].hash
        new_block.hash = new_block.calculate_hash()
        self.chain.append(new_block)

blockchain = Blockchain()

block1 = Block(1, datetime.datetime.now(), {"sender": "Siddharth", "receiver": "Edith", "amount": 15}, "")
blockchain.add_block(block1)

block2 = Block(2, datetime.datetime.now(), {"sender": "Shresth", "receiver": "Vibhor", "amount": 20}, "")
blockchain.add_block(block2)

for block in blockchain.chain:
    print(f"Block: {block.index}")
    print(f"Timestamp: {block.timestamp}")
    print(f"Transactions: {block.transactions}")
    print(f"Hash: {block.hash}")
    print("--------------------")