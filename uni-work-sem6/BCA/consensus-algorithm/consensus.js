class Block {
    constructor(index, previousHash, timestamp, data, hash) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
    }
}

class Node {
    constructor(id) {
        this.id = id;
        this.chain = [];
        this.votes = {};
    }

    createBlock(previousHash, data) {
        const index = this.chain.length;
        const timestamp = Date.now();
        const hash = this.calculateHash(index, previousHash, timestamp, data);
        const block = new Block(index, previousHash, timestamp, data, hash);
        return block;
    }

    calculateHash(index, previousHash, timestamp, data) {
        return require('crypto').createHash('sha256').update(index + previousHash + timestamp + JSON.stringify(data)).digest('hex');
    }

    proposeBlock(data) {
        const previousBlock = this.chain[this.chain.length - 1];
        const previousHash = previousBlock ? previousBlock.hash : '0';
        const newBlock = this.createBlock(previousHash, data);

        // Vote on the new block
        this.voteOnBlock(newBlock);
    }

    voteOnBlock(block) {
        // Simulate voting process (this would be distributed in a real network)
        const totalNodes = 5; // Simulate 5 nodes in the network
        const votesNeeded = Math.ceil(totalNodes / 2); // Majority votes
        const voteResult = { yes: 0, no: 0 };

        // Each node votes (in a real scenario, this would be done by other nodes)
        for (let i = 0; i < totalNodes; i++) {
            // For simplicity, let's assume nodes vote randomly
            const vote = Math.random() > 0.5 ? 'yes' : 'no';
            voteResult[vote]++;
        }

        console.log(`Votes for block ${block.hash}: Yes: ${voteResult.yes}, No: ${voteResult.no}`);

        // Check if the block receives enough votes
        if (voteResult.yes >= votesNeeded) {
            console.log(`Block ${block.hash} is accepted.`);
            this.chain.push(block);
        } else {
            console.log(`Block ${block.hash} is rejected.`);
        }
    }
}

// Usage
const node1 = new Node(1);
const node2 = new Node(2);
const node3 = new Node(3);
const node4 = new Node(4);
const node5 = new Node(5);

// Node 1 proposes a block
node1.proposeBlock({ amount: 10 });

// Log the blockchain for node 1
console.log(JSON.stringify(node1.chain, null, 4));

// Other nodes can propose blocks similarly, and they can have their own chains
