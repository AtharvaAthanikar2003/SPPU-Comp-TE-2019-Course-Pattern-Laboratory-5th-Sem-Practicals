#include<iostream>
#include<cstdlib>
using namespace std;
void gobackN(int nf,int fpers){
    int n=0;
    int cf=0;
    while(n<nf){       
        for(int i=cf+1;i<cf+fpers;i++){    
            int r=rand()%2;           
            if(i>nf){            
            break;
            }           
            else{
                if(r){               
                 cout<<"Transmitting Frame No."<<i<<"...."<<endl;
                 cout<<"Acknowledgement:- Success"<<endl<<endl;
                 n++;
                 cf=i;       
                }            
             else{                
                cout<<"Error While Transfering Frame No."<<i<<endl<<endl;
                break;
                }
            }
        }
    }  
    cout<<"Transmission Successful"<<endl;
}    
int main(){
    int frame_no,fs;
    cout<<"---------SIMULATION FOR 'GO-BACK-N' ARQ PROTOCOL---------"<<endl<<endl;
    cout<<"Enter The No.of Frames-:";
    cin>>frame_no;
    cout<<"Enter The Windows Length-:";
    cin>>fs;
    cout<<endl;
    gobackN(frame_no,fs);
}
