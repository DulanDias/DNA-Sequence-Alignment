# DNA Sequence Alignment with Dynamic Programming

<h3>Dynamic Programming</h3>
<p>Dynamic programming is an algorithmic technique used commonly in sequence analysis. Dynamic programming is used when recursion could be used but would be inefficient because it would repeatedly solve the same subproblems.</p>

<h3>Sequence alignment</h3>
<p>A major theme of genomics is comparing DNA sequences and trying to align the common parts of two sequences. If two DNA sequences have similar subsequences in common — more than you would expect by chance — then there is a good chance that the sequences are homologous (see "Homology" sidebar). In aligning two sequences, you consider not only characters that match identically, but also spaces or gaps in one sequence (or, conversely, insertions in the other sequence) and mismatches, both of which can correspond to mutations. In sequence alignment, you want to find an optimal alignment that, loosely speaking, maximizes the number of matches and minimizes the number of spaces and mismatches. More formally, you can determine a score for each possible alignment by adding points for matching characters and subtracting points for spaces and mismatches.</p>

<h4>Global and local sequence alignment</h4>
<p>Global sequence alignment tries to find the best alignment between an entire sequence S1 and another entire sequence S2.</p>

<p>Consider these two DNA sequences:<p>

<li>S1 = GCCCTAGCG</li>
<li>S2 = GCGCAATG</li>

<p>If you award matches one point, penalize spaces by two points, and penalize mismatches by one point, the following is an optimal global alignment:</p>

<li>S1' = GCCCTAGCG</li>
<li>S2' = GCGC-AATG</li>

<p>With local sequence alignment, you're not constrained to aligning the whole of both sequences; you can just use parts of each to obtain a maximum score. Using the same sequences S1 and S2 and the same scoring scheme, you obtain the following optimal local alignment S1'' and S2'':</p>

<li>S1   = GCCCTAGCG</li>
<li>S1'' =       GCG</li>
<li>S2'' =       GCG</li>
<li>S2   =       GCGCAATG</li>

<p>This local alignment doesn't happen to have any mismatches or spaces, although, in general, local alignments can have them.</p>

<h3>What's included here:</h3>

<p>The <b>Needleman-Wunsch algorithm</b> is used for computing global alignments. The idea is similar to the LCS algorithm. Again, you have a two-dimensional table with one sequence along the top and one along the left side. Again, you can arrive at each cell in one of three ways:</p>

<li>From the cell above, which corresponds to aligning the character to the left with a space</li>
<li>From the cell to the left, which corresponds to aligning the character above with a space</li>
<li>From the cell diagonally to the above-left, which corresponds to aligning the characters to the left and above (which might or might not match)</li>

<p>In the <b>Smith-Waterman algorithm</b>, you're not constrained to aligning the entire sequences. This, and the fact that two zero-length strings is a local alignment with score of 0, means that in building up a local alignment you don't need to "go into the red" and have partial scores that are negative. That would cause further alignments to have a score lower than you could get by "resetting" with two zero-length strings. Also, your local alignment doesn't need to end at the end of either sequence, so you don't need to start your traceback in the bottom-right corner; you can start it in the cell with the highest score.</p>
