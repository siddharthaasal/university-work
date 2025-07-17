# dApp Assignment 1
---

### **1. Define Blockchain and List Its Key Features**

**Definition:**
Blockchain is a decentralized, distributed digital ledger that records transactions across multiple computers in a way that ensures security, transparency, and immutability. Each block contains a list of transactions, and blocks are linked using cryptographic hashes, forming a continuous chain.

**Key Features:**

* **Decentralization:** No central authority; all participants (nodes) share control.
* **Immutability:** Once recorded, data cannot be altered or deleted.
* **Transparency:** All transactions are visible to network participants.
* **Security:** Uses cryptography (e.g., hashing and digital signatures) to secure data.
* **Consensus Mechanisms:** Nodes agree on a single version of truth using protocols like Proof of Work (PoW) or Proof of Stake (PoS).

---

### **2. Difference Between Public and Private Blockchains**

| Feature       | Public Blockchain                        | Private Blockchain                     |
| ------------- | ---------------------------------------- | -------------------------------------- |
| **Access**    | Open to anyone                           | Restricted to selected participants    |
| **Control**   | Decentralized                            | Centralized or partially decentralized |
| **Speed**     | Slower due to more nodes and validations | Faster with fewer participants         |
| **Examples**  | Bitcoin, Ethereum                        | Hyperledger Fabric, R3 Corda           |
| **Consensus** | PoW, PoS                                 | Pre-approved consensus (e.g., PBFT)    |

---

### **3. Two Characteristics of a Permission-less Blockchain**

1. **Open Participation:**
   Anyone can join the network and participate in validating transactions and creating blocks without requiring authorization.

2. **Transparency & Public Ledger:**
   All transaction data is publicly available, allowing anyone to audit and verify records.

---

### **4. Explain Cryptographic Technologies Used in Blockchain with Relevant Examples**

Blockchain relies heavily on cryptographic techniques to ensure data security and trust.

* **Hashing (e.g., SHA-256):**
  Converts input data into a fixed-length string. Used for block IDs and linking blocks.
  *Example:* Bitcoin uses SHA-256 to secure block data and ensure immutability.

* **Digital Signatures (e.g., ECDSA):**
  Ensures transaction authenticity and integrity. The sender signs the transaction with a private key, and others can verify it using the public key.
  *Example:* In Ethereum, transactions are signed with ECDSA to prove sender identity.

* **Merkle Trees:**
  Organize transactions in a tree structure using hashes. Helps in quick verification of large sets of data.
  *Example:* Bitcoin uses Merkle trees for efficient transaction verification in blocks.

---

### **5. Describe Different Types of Blockchain with Examples**

1. **Public Blockchain:**
   Open and decentralized. Anyone can read/write data and participate.
   *Example:* Bitcoin, Ethereum

2. **Private Blockchain:**
   Restricted access. Used within organizations.
   *Example:* Hyperledger Fabric (used in supply chain)

3. **Consortium Blockchain (Federated):**
   Controlled by a group of institutions. Balances decentralization and privacy.
   *Example:* R3 Corda (used in banking)

4. **Hybrid Blockchain:**
   Combines public and private features. Data is partly open and partly private.
   *Example:* XinFin (enterprise blockchain solutions)

---

### 📊 **Suggested Diagrams**

* **Blockchain Structure:**
  A diagram showing blocks linked in a chain with each block containing hash of the previous block, timestamp, and transaction data.

* **Public vs Private Blockchain Comparison Table:**
  A clean comparison chart for clarity.

* **Cryptographic Workflow:**

  * Transaction → Hashing → Digital Signature → Broadcast → Validation
  * Optional: Merkle Tree structure for transaction grouping

---
