# Conference assignments

import gurobipy as gp
from gurobipy import GRB
import pandas as pd
import os

pre = os.path.dirname(os.path.realpath(__file__))
fname = 'papers.csv'
path = os.path.join(pre, fname)
df = pd.read_csv(path, header=None)
df[0] = df[0].str.split(",")
df[3] = df[3].str.split(",")
df[3] = df[3].apply(set)
print(df)

fname = 'constraints.csv'
path = os.path.join(pre, fname)
df2 = pd.read_csv(path, header=None)
print(df2)

fname = 'info.csv'
path = os.path.join(pre, fname)
df3 = pd.read_csv(path, header=None)
print(df3)

Inum = len(df)
Jnum = df3[3].sum()
Dnum = len(df2)

I=range(Inum)
J=range(Jnum)
D=range(1, Dnum+1)

H = [h for h in range(9, 17)] ##### problem
T = [t for t in range(2)] ##### problem

A = []
for i in I:
    for a in df.loc[i,0]:
        A.append(a)
A = list(set(A))
print(A)

M = []
for i in I:
    M.append(df.loc[i,1])
M = list(set(M))
print(M)

PA = {i : {a : 0 for a in A} for i in I}
for i in I:
    for a in df.loc[i,0]:
        PA[i][a] = 1

PM = {i : {m : 0 for m in M} for i in I}
for i in I:
    PM[i][df.loc[i,1]] = 1
print(PM)

PSC = {df2.loc[d,0] : df2.loc[d,1] for d in range(len(df2))}
print(PSC)

C = [[0 for p in I] for i in I]
for i in I:
    for p in I:
        if i==p:
            C[i][p] = 0
        else:
            C[i][p] = len(df.loc[i,3].intersection(df.loc[p,3]))
print(pd.DataFrame(C))

# Model
m = gp.Model("conference")

# Decision variables
x = m.addVars(J,D,H,vtype=GRB.BINARY)
y = m.addVars(I,J,D,H,T,vtype=GRB.BINARY)
v = m.addVars(I,I,J,vtype=GRB.BINARY)

# Objective function
m.setObjective(sum(C[i][p] * v[i,p,j] for i in I for p in I for j in J), GRB.MAXIMIZE)
print("const 0 done")

#1
m.addConstrs(sum(x[j,d,h] for d in D for h in H) == 1 for j in J)
print("const 1 done")

#2
#m.addConstrs(sum(x[j,d,h] for j in J) <= PSC[d] for d in D for h in H)
print("const 2 done")
#3
m.addConstrs(sum(y[i,j,d,h,t] for j in J for d in D for h in H for t in T) == 1 for i in I)
print("const 3 done")
#4
m.addConstrs(sum(y[i,j,d,h,t] * PA[i][a] for i in I for j in J for t in T) <= 1 for a in A for d in D for h in H)
print("const 4 done")
#5
m.addConstrs(sum(y[i,j,d,h,t] * PM[i][m] for i in I for j in J for t in T) <= 1 for m in M for d in D for h in H)
print("const 5 done")


#6
m.addConstrs(y[i,j,d,h,t] <= x[j,d,h] for i in I for j in J for d in D for h in H for t in T)
print("const 6 done")
#7
m.addConstrs(2 * v[i,p,j] <= sum(y[i,j,d,h,t] for d in D for h in H for t in T) +
             sum(y[p,j,d,h,t] for d in D for h in H for t in T)  for i in I for p in I for j in J)
print("const 7 done")
#8
m.addConstrs(sum(y[i,j,d,h,t] for i in I for j in J ) <= 1 for d in D for h in H for t in T)
print("const 8 done")


# Solve
m.optimize()
print("optimizing")
# Print solution
print('\nObj func value: %g' % m.objVal)
print('SOLUTION:', end='')
df4 = pd.DataFrame(columns=range(0,9))
for d in D:
    for j in J:
        for t in T:
            for h in H:
                for i in I:
                    if y[i,j,d,h,t].X==1:
                        df4.loc[len(df4)] = [d, j, df2.loc[d-1,1], df.loc[i,0], df.loc[i,1], df.loc[i,2], df.loc[i,3],
                                             df2.loc[d-1,4], df2.loc[d-1,5]]
print(df4)

fname = 'result.csv'
path = os.path.join(pre, fname)
df4.to_csv(path, header=None, index=False)