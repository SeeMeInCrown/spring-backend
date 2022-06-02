# Conference assignments

import gurobipy as gp
from gurobipy import GRB

n = 5
Inum = n
Jnum = n
Knum = n
Dnum = n
H = [h for h in range(9, 17)]
Anum = n
Mnum = n

I=range(Inum)
J=range(Jnum)
K=range(Knum)
D=range(Dnum)
H=range(len(H))
A=range(Anum)
M=range(Mnum)

T = [[1 if h==j else 0 for h in H] for j in J]
PA = [[1 if a==i else 0 for a in A] for i in I]
PSC = 2

# Model
m = gp.Model("conference")

# Decision variables
x = m.addVars(J,D,vtype=GRB.BINARY)
y = m.addVars(I,J,K,D,vtype=GRB.BINARY)
z = m.addVars(M,I,J,K,D,vtype=GRB.BINARY)

# Objective function
m.setObjective(1, GRB.MINIMIZE)

#1
m.addConstrs(sum(x[j,d] for d in D) == 1 for j in J)

#2
m.addConstrs(sum(x[j,d] * T[j][h] for j in J) <= PSC for d in D for h in H)

#3
m.addConstrs(sum(y[i,j,k,d] for j in J for k in K for d in D) == 1 for i in I)

#4
m.addConstrs(sum(y[i,j,k,d] * T[j][h] for i in I for j in J) <= 1 for k in K for d in D for h in H)

#5
m.addConstrs(sum(y[i,j,k,d] * PA[i][a] * T[j][h] for i in I for j in J for k in K) <= 1 
                                                                                for a in A for d in D for h in H)

#6
m.addConstrs(sum(z[m,i,j,k,d] for m in M) == y[i,j,k,d] for i in I for j in J for k in K for d in D)

#7
m.addConstrs(sum(z[m,i,j,k,d] * T[j][h] for i in I for j in J for k in K) <= 1 for m in M for d in D for h in H)

#8
m.addConstrs(y[i,j,k,d] <= x[j,d] for i in I for j in J for k in K for d in D)

# Solve
m.optimize()

# Print solution
print('\nObj func value: %g' % m.objVal)
print('SOLUTION:', end='')
for i in I:
    for j in J:
        for k in K:
            for d in D:
                if y[i,j,k,d].X==1:
                    print('\n%d,%d,%d,%d' %(i,j,k,d), end='')
print('\n')