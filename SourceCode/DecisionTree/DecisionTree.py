
# coding: utf-8

# In[40]:


from sklearn.feature_extraction import DictVectorizer
import csv
from sklearn import preprocessing
from sklearn import tree
from sklearn.externals.six import StringIO

allElectronicsData = open(r'D:\harrytsz-MachineLearningSpace\AllElectronics.csv', 'rt')
reader = csv.reader(allElectronicsData)
headers = next(reader)

print(headers)


# In[41]:


featureList = []
labelList = []

for row in reader:
    labelList.append(row[-1])
    rowDict = {}
    for i in range(1, len(row)-1):
        rowDict[headers[i]] = row[i]
    featureList.append(rowDict)
print(featureList)


# In[42]:


vec = DictVectorizer()
dummyX = vec.fit_transform(featureList).toarray()

print("dummyX: \n" + str(dummyX))

print(vec.get_feature_names())

print("labelList: \n" + str(labelList))


# In[43]:


lb = preprocessing.LabelBinarizer()
dummyY = lb.fit_transform(labelList)
print("dummyY: \n" + str(dummyY))


clf = tree.DecisionTreeClassifier(criterion='entropy')
clf = clf.fit(dummyX, dummyY)
print("clf: \n" + str(clf))


# In[44]:


#Visulize model

with open("allElectronicInformationGainOri.dot", 'w') as f:
    f = tree.export_graphviz(clf, feature_names=vec.get_feature_names(), out_file = f)


# In[45]:


# predict
oneRowX = dummyX[0, :]
print("oneRowX: " + str(oneRowX))

newRowX = oneRowX
newRowX[0] = 1
newRowX[2] = 0
print("newRowX: " + str(newRowX))

predictedY = clf.predict(newRowX.reshape(1,-1))
print("predictedY: " + str(predictedY))

