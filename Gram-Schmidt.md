- Process used to convert a basis to an orthonormal basis
- to convert a basis of $v_1, v_2... v_n$ to an orthonormal basis of $u_1, u_2...u_n$
  $u_k =v_k - \sum_{j=1}^{k-1} proj_{u_j}(v_k)$
- Calculating  by hand is the same as:
	- $e_1 = norm(v_1)$
	- $e_2 = norm(v_2 - (v_2 \cdot e_1) e_1)$ or 
	  $e_2 = norm(v_2 - (v_2 \cdot v_1)v_1/||v_1||^2 )$