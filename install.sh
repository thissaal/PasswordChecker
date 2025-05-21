#!/bin/bash

echo "🔧 Compiling PasswordTester.java..."
javac PasswordTester.java

if [ $? -eq 0 ]; then
    echo "✅ Compiled successfully!"

    echo "🔗 Setting up executable..."

    chmod +x PasswordCracker

    read -p "Do you want to run 'PasswordCracker' from anywhere on your system? (y/n): " choice
    if [ "$choice" == "y" ]; then
        sudo cp PasswordCracker /usr/local/bin/
        echo "✅ You can now run 'PasswordCracker' from anywhere."
    else
        echo "ℹ️ You can run it locally with ./PasswordCracker"
    fi
else
    echo "❌ Compilation failed."
    exit 1
fi
