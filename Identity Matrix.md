- The identity matrix is the zero matrix with ones on the diagonal.
- An $$n \times n$$ identity matrix is denoted $$I_n$$
- This matrix has the interesting property of being the multiplicative identity of all [square matrices]([[Square matrices]]).
  This means that if $$A$$ is an $$m \times n $$ matrix then the following holds: $$AI_m= A = I_nA$$
- The [[Rank]] of the identity matrix is equal to its size
- The ID matrix is [idempotent]([[Idempotent matrices]]), meaning all rows and columns are [independent]([[Linear independence]]) and that $$I_n^k = I_n \ \forall k \in \mathbb{N}$$
- The identity matrix is the only [idempotent]([[Idempotent matrices]]) that is [invertible]([[Inverse]])
  Proof: Suppose we have an idempotent matrix $A=A^2$
  $$AA^{-1} = I$$
  $$A^2A^{-1} = I$$
  $$A = I\  \blacksquare$$