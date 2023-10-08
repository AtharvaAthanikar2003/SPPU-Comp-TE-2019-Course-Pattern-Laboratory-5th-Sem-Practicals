# Python Code designed for paper prototyping

import tkinter as tk
from tkinter import ttk, messagebox, filedialog
from PIL import Image, ImageTk

def open_registration_window():
    registration_window = tk.Toplevel(root)
    registration_window.title("Registration Page")
    registration_window.geometry("600x600")

    style = ttk.Style()
    style.theme_use("clam")  # Choose a ttk theme (you can try different themes)

    def browse_image():
        file_path = filedialog.askopenfilename()
        if file_path:
            load_image(file_path)

    def load_image(file_path):
        image = Image.open(file_path)
        image = image.resize((150, 150), Image.ANTIALIAS)
        photo = ImageTk.PhotoImage(image)

        # Display the photo
        photo_label.config(image=photo)
        photo_label.image = photo

    full_name_label = ttk.Label(registration_window, text="Full Name:")
    full_name_label.grid(row=0, column=0, sticky="w", padx=10, pady=5)
    full_name_entry = ttk.Entry(registration_window)
    full_name_entry.grid(row=0, column=1, padx=10, pady=5)

    address_label = ttk.Label(registration_window, text="Address:")
    address_label.grid(row=1, column=0, sticky="w", padx=10, pady=5)
    address_entry = ttk.Entry(registration_window)
    address_entry.grid(row=1, column=1, padx=10, pady=5)

    email_label = ttk.Label(registration_window, text="Email:")
    email_label.grid(row=2, column=0, sticky="w", padx=10, pady=5)
    email_entry = ttk.Entry(registration_window)
    email_entry.grid(row=2, column=1, padx=10, pady=5)

    mobile_label = ttk.Label(registration_window, text="Mobile No:")
    mobile_label.grid(row=3, column=0, sticky="w", padx=10, pady=5)
    mobile_entry = ttk.Entry(registration_window)
    mobile_entry.grid(row=3, column=1, padx=10, pady=5)

    country_label = ttk.Label(registration_window, text="Country:")
    country_label.grid(row=4, column=0, sticky="w", padx=10, pady=5)
    country_entry = ttk.Entry(registration_window)
    country_entry.grid(row=4, column=1, padx=10, pady=5)

    state_label = ttk.Label(registration_window, text="State:")
    state_label.grid(row=5, column=0, sticky="w", padx=10, pady=5)
    state_entry = ttk.Entry(registration_window)
    state_entry.grid(row=5, column=1, padx=10, pady=5)

    city_label = ttk.Label(registration_window, text="City:")
    city_label.grid(row=6, column=0, sticky="w", padx=10, pady=5)
    city_entry = ttk.Entry(registration_window)
    city_entry.grid(row=6, column=1, padx=10, pady=5)

    gender_label = ttk.Label(registration_window, text="Gender:")
    gender_label.grid(row=7, column=0, sticky="w", padx=10, pady=5)
    gender_var = tk.StringVar()
    male_radio = ttk.Radiobutton(registration_window, text="Male", variable=gender_var, value="Male")
    female_radio = ttk.Radiobutton(registration_window, text="Female", variable=gender_var, value="Female")
    male_radio.grid(row=7, column=1, sticky="w", padx=10, pady=5)
    female_radio.grid(row=7, column=1, sticky="e", padx=10, pady=5)

    language_label = ttk.Label(registration_window, text="Languages:")
    language_label.grid(row=8, column=0, sticky="w", padx=10, pady=5)
    language_vars = []
    languages = ["Marathi", "English", "Hindi"]
    for i, lang in enumerate(languages):
        lang_var = tk.StringVar()
        lang_checkbox = ttk.Checkbutton(registration_window, text=lang, variable=lang_var, onvalue=lang, offvalue="")
        lang_checkbox.grid(row=8 + i, column=1, sticky="w", padx=10, pady=2)
        language_vars.append(lang_var)

    photo_label = ttk.Label(registration_window, text="Upload Photo:")
    photo_label.grid(row=9 + len(languages), column=0, sticky="w", padx=10, pady=5)
    browse_button = ttk.Button(registration_window, text="Browse", command=browse_image)
    browse_button.grid(row=9 + len(languages), column=1, padx=10, pady=5)

    def register():
        messagebox.showinfo("Submit", "Successfully signed up!")

    register_button = ttk.Button(registration_window, text="Submit", command=register)
    register_button.grid(row=10 + len(languages), columnspan=2, pady=10)

def login():
    messagebox.showinfo("Login", "Login successful")

def signup():
    open_registration_window()

root = tk.Tk()
root.title("Login Page")

style = ttk.Style()
style.theme_use("clam")  # Choose a ttk theme (you can try different themes)

label1 = ttk.Label(root, text="Login")
label1.grid(row=0, column=0, padx=10, pady=5)
label2 = ttk.Label(root, text="Username")
label2.grid(row=1, column=0, padx=10, pady=5)
label3 = ttk.Label(root, text="Password")
label3.grid(row=2, column=0, padx=10, pady=5)

Username = ttk.Entry(root)
Username.grid(row=1, column=1, padx=10, pady=5)
password = ttk.Entry(root, show="●")
password.grid(row=2, column=1, padx=10, pady=5)

button1 = ttk.Button(root, text="Log In", command=login)
button1.grid(row=3, column=0, padx=10, pady=10)
button2 = ttk.Button(root, text="Sign Up", command=signup)
button2.grid(row=3, column=1, padx=10, pady=10)

root.mainloop()
