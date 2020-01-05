#include<iostream>
#include<vector>
#include<iterator>

using namespace std;

void displayVectorContents(vector <int> v)
{
	for( auto i = v.begin(); i != v.end(); i++)
		{
				if(*i == -1)
					cout << " " <<"," <<" ";
				else
					cout << *i;
		}
	cout << "\n";

return;
}

vector <int> addByDigit(vector <int> v)
{
	vector <int> inter; // for itermediate storage
	vector <int> stored; // for final storage
	
	auto i = v.begin();
	while(*(i+1) != -1)
		i++;
	
	auto j = i + 2; 
	while(true)
		{
			stored.push_back(*j);
			if(j+1 == v.end())
				break;
			else
				j++;
			
		}
	stored.push_back(-1);
	
	int carry = 0, sum = 0;
	auto i1 = v.rbegin();
	
		while(*i1 != -1) // readying the reverse iterator for traversals. 
			{
				i1++;
			}
	i1++;
		
	while(i1 != v.rend())
		{
			sum = carry + *i + *j;
				if(sum >= 10) // sum of digits result in a carry
					{
						inter.push_back(sum-10);
						carry = 1;
					}
				else // sum of digits doesn't result in carry
					{
						inter.push_back(sum);
						carry = 0;
					}
				i--;
				j--;
				i1++;
		}
	if(*j != -1 ) // applicable when (n+1)th terms has one more digit then nth term
		{
			sum = *j + carry; // add carry to the last digit of the (n+1)th term
			if(sum >= 10)
				{
					inter.push_back(sum-10);
					inter.push_back(1);
				}
			else
				{
					inter.push_back(sum);
				}
		}
	else // when the addition of nth and the (n+1)th terms's last digit results in a carry
		{
			if(carry == 1)
				inter.push_back(carry);
		}
		
	auto k = inter.rbegin(); // the next fibonacci is stored in the 'inter' vector in reversed form.
		while(k != inter.rend())
			{
				stored.push_back(*k);
				k++;
			}

return stored;
}

int main()
{
 vector <int> start = {0,-1,1};
 	displayVectorContents(start);
	 for (int i = 1; i <= 100; i++)
 		{
 			start = addByDigit(start);
 			cout << "\n";
			 displayVectorContents(start);
 			
	
		 }
return 0;
}
