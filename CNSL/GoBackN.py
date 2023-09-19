import random

def gobackN(nf, fpers):
    n = 0
    cf = 0
    while n < nf:
        for i in range(cf + 1, cf + fpers):
            r = random.randint(0, 1)
            if i > nf:
                break
            else:
                if r:
                    print("Transmitting Frame No.", i, "....")
                    print("Acknowledgement :- Success\n")
                    n += 1
                    cf = i
                else:
                    print("Error While Transfering Frame No.", i, "\n")
                    break
    print("Transmission Successful")

if __name__ == "__main__":
    frame_no = int(input("Enter The No.of Frames :- "))
    fs = int(input("Enter The Windows Length :- "))
    print()
    gobackN(frame_no, fs)
