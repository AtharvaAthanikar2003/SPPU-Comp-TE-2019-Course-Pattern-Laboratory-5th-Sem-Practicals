# HCI Code prepared for Login Registration Form using tkinter library.

# HCI 2nd Lab Assignment No.2

import tkinter as tk
from tkinter import ttk, messagebox, filedialog
from PIL import Image, ImageTk

BACKGROUND_COLOR = "#e6f7ff"  # Light blue background
TEXT_COLOR = "#333333"        # Dark gray text color
BUTTON_COLOR = "#4CAF50"       # Green button color
BUTTON_TEXT_COLOR = "#ffffff"  # White button text color
ENTRY_BACKGROUND = "#ffffff"    # White background for entry widgets

def open_registration_window():
    registration_window = tk.Toplevel(root)
    registration_window.title("Registration Page")
    registration_window.geometry("800x600")

    style = ttk.Style()
    style.theme_use("clam")

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

    # Use Frame for better organization
    content_frame = ttk.Frame(registration_window, padding=(20, 10, 20, 10))
    content_frame.grid(row=0, column=0, sticky="nsew")
    registration_window.columnconfigure(0, weight=1)
    registration_window.rowconfigure(0, weight=1)

    # Center align the content
    for i in range(16):  # Assuming there are 16 rows in your content frame
        content_frame.rowconfigure(i, weight=1)

    full_name_label = ttk.Label(content_frame, text="Full Name:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    full_name_label.grid(row=0, column=0, sticky="w", padx=10, pady=5)
    full_name_entry = ttk.Entry(content_frame, font=("Helvetica", 12), background=ENTRY_BACKGROUND, width=30)
    full_name_entry.grid(row=0, column=1, padx=10, pady=5)

    address_label = ttk.Label(content_frame, text="Address:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    address_label.grid(row=1, column=0, sticky="w", padx=10, pady=5)
    address_entry = ttk.Entry(content_frame, width=30)
    address_entry.grid(row=1, column=1, padx=10, pady=5)

    email_label = ttk.Label(content_frame, text="Email:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    email_label.grid(row=2, column=0, sticky="w", padx=10, pady=5)
    email_entry = ttk.Entry(content_frame, width=30)
    email_entry.grid(row=2, column=1, padx=10, pady=5)

    mobile_label = ttk.Label(content_frame, text="Mobile No:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    mobile_label.grid(row=3, column=0, sticky="w", padx=10, pady=5)
    mobile_entry = ttk.Entry(content_frame, width=30)
    mobile_entry.grid(row=3, column=1, padx=10, pady=5)

    country_label = ttk.Label(content_frame, text="Country:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    country_label.grid(row=4, column=0, sticky="w", padx=10, pady=5)

    countries = ["India", "USA", "Canada", "UK", "Europe", "Australia", "New Zealand", "Russia", "Africa", "Antarctica"]
    country_var = tk.StringVar()
    max_country_len = max(len(country) for country in countries)
    country_combobox = ttk.Combobox(content_frame, textvariable=country_var, values=countries, width=max_country_len + 2)
    country_combobox.grid(row=4, column=1, padx=10, pady=5)

    state_label = ttk.Label(content_frame, text="State:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    state_label.grid(row=5, column=0, sticky="w", padx=10, pady=5)

    famous_states = {
        "India": ["Maharashtra", "Karnataka", "Telangana", "Andhra Pradesh", "Tamil Nadu", "Kerala", "Gujarat", "West Bengal", "Uttar Pradesh", "Madhya Pradesh", "Punjab", "Rajasthan", "Haryana", "Bihar", "Odisha", "Assam"],
        "USA": ["California", "Washington D.C", "Florida", "New York", "Illinois", "Pennsylvania", "New Jersey", "Georgia", "Massachusetts", "Michigan"],
        "Canada": ["Ontario", "Quebec", "British Columbia", "Alberta", "Manitoba", "Saskatchewan", "Nova Scotia", "New Brunswick", "Newfoundland and Labrador", "Prince Edward Island"],
        "UK": ["London", "Manchester", "Birmingham", "Liverpool", "Glasgow", "Edinburgh", "Leeds", "Bristol", "Sheffield", "Newcastle"],
        "Europe": ["France", "Germany", "Italy", "Spain", "Netherlands", "Belgium", "Switzerland", "Austria", "Sweden", "Norway"],
        "Australia": ["New South Wales", "Queensland", "Victoria", "Western Australia", "South Australia", "Tasmania", "Australian Capital Territory", "Northern Territory", "New Zealand"],
        "New Zealand": ["Auckland", "Wellington", "Christchurch", "Hamilton", "Tauranga", "Dunedin", "Palmerston North", "Napier-Hastings", "Hamilton", "Dunedin"],
        "Russia": ["Moscow", "Saint Petersburg", "Novosibirsk", "Yekaterinburg", "Nizhny Novgorod", "Kazan", "Chelyabinsk", "Omsk", "Samara", "Ufa"],
        "Africa": ["Nigeria", "South Africa", "Egypt", "Kenya", "Ethiopia", "Tanzania", "Ghana", "Morocco", "Uganda", "Algeria"],
        "Antarctica": ["McMurdo Station", "Amundsen-Scott South Pole Station", "Palmer Station", "Davis Station", "Casey Station", "Mawson Station", "Rothera Research Station", "Halley Research Station", "Scott Base", "Vostok Station"]       
    }

    state_var = tk.StringVar()
    max_state_len = max(len(state) for states in famous_states.values() for state in states)
    state_combobox = ttk.Combobox(content_frame, textvariable=state_var, values=[], width=max_state_len + 2)
    state_combobox.grid(row=5, column=1, padx=10, pady=5)

    def update_states(event):
        selected_country = country_var.get()
        state_combobox['values'] = famous_states.get(selected_country, [])
    country_combobox.bind("<<ComboboxSelected>>", update_states)

    city_label = ttk.Label(content_frame, text="City:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    city_label.grid(row=6, column=0, sticky="w", padx=10, pady=5)
    city_entry = ttk.Entry(content_frame, width=30)
    city_entry.grid(row=6, column=1, padx=10, pady=5)

    language_label = ttk.Label(content_frame, text="Languages:")
    language_label.grid(row=7, column=0, sticky="w", padx=10, pady=5)
    language_entry = ttk.Entry(content_frame, width=30)
    language_entry.grid(row=7, column=1, padx=10, pady=5)
    
    gender_label = ttk.Label(content_frame, text="Gender:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    gender_label.grid(row=8, column=0, sticky="w", padx=10, pady=5)
    gender_var = tk.StringVar()
    male_radio = ttk.Radiobutton(content_frame, text="Male", variable=gender_var, value="Male")
    female_radio = ttk.Radiobutton(content_frame, text="Female", variable=gender_var, value="Female")
    male_radio.grid(row=8, column=1, sticky="w", padx=10, pady=5)
    female_radio.grid(row=8, column=1, sticky="e", padx=10, pady=5)

    photo_label = ttk.Label(content_frame, text="Upload Photo:", font=("Helvetica", 14), foreground=TEXT_COLOR)
    photo_label.grid(row=11, column=0, columnspan=2, sticky="w", padx=10, pady=5)

    browse_button = ttk.Button(content_frame, text="Browse", command=browse_image, style="TButton")
    browse_button.grid(row=11, column=1, columnspan=2, pady=5)

    def register():
        registration_window.destroy()
        messagebox.showinfo("Submit", "Successfully signed up!")

    register_button = ttk.Button(content_frame, text="Submit", command=register, style="TButton")
    register_button.grid(row=12, column=0, columnspan=5, pady=10)

    # Center the content horizontally
    for i in range(4):
        content_frame.columnconfigure(i, weight=1)

    # Center the window on the screen
    registration_window.eval('tk::PlaceWindow %s center' % registration_window.winfo_toplevel())

def login():
    messagebox.showinfo("Login", "Login successful")

def signup():
    open_registration_window()

root = tk.Tk()
root.title("Login Page")

# Set the background color
root.configure(bg=BACKGROUND_COLOR)

style = ttk.Style()
style.theme_use("clam")

# Define styles for widgets
style.configure("TLabel", foreground=TEXT_COLOR, font=("Helvetica", 16))
style.configure("TEntry", background=ENTRY_BACKGROUND, font=("Helvetica", 14))
style.configure("TButton", background=BUTTON_COLOR, foreground=BUTTON_TEXT_COLOR, font=("Helvetica", 16))
style.configure("TRadiobutton", font=("Helvetica", 12))

label1 = ttk.Label(root, text="Login", style="TLabel")
label1.grid(row=0, column=0, padx=10, pady=20, columnspan=4)

label2 = ttk.Label(root, text="Username", style="TLabel")
label2.grid(row=1, column=0, padx=10, pady=5, sticky="w")

label3 = ttk.Label(root, text="Password", style="TLabel")
label3.grid(row=2, column=0, padx=10, pady=5, sticky="w")

username = ttk.Entry(root)
username.grid(row=1, column=1, padx=10, pady=5, sticky="ew")

password = ttk.Entry(root, show="●")
password.grid(row=2, column=1, padx=10, pady=5, sticky="ew")

button1 = ttk.Button(root, text="Log In", command=login, style="TButton")
button1.grid(row=3, column=0, padx=10, pady=20, columnspan=4, sticky="ew")

button2 = ttk.Button(root, text="Sign Up", command=signup, style="TButton")
button2.grid(row=4, column=0, padx=10, pady=20, columnspan=4, sticky="ew")

# Set the minimum size of the window
root.update_idletasks()
root.minsize(root.winfo_reqwidth(), root.winfo_reqheight())

# Center the window on the screen
root.eval('tk::PlaceWindow %s center' % root.winfo_toplevel())

root.mainloop()
