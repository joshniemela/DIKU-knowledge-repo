- Given two ordered [[Bases]] $\mathcal{B}, \mathcal{C}$, the shift matrix from C to B is defined as follows:
  $P_{\mathcal{C} \to \mathcal{B}} := ([c_1]_{\mathcal{B}}| ... | [c_k]_{\mathcal{B}})$
  It satisfies $[V]_{\mathcal{B}} = P_{\mathcal{C} \to \mathcal{B}} [V]_\mathcal{c}\, \forall v \in \mathcal{U}$ where $\mathcal{U}$ is a mutual [[Subspaces]]
- Calculation of basis shift:
	- Solve for all the vectors of C in respect to a linear combination of the B vectors
	- ![image.png](../assets/image_1683705213599_0.png)
- Mnemonic for finding $P_{B \leftarrow A}$
  the matrix to solve is $[B | A]$
- The [[Inverse]] is a change of basis from the standard basis to a given basis $\mathcal{B}$.