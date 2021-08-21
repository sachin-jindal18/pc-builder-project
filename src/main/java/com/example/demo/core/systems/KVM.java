package com.example.demo.core.systems;

import com.example.demo.core.peripherals.Display;
import com.example.demo.core.peripherals.Keyboard;
import com.example.demo.core.peripherals.Mouse;

public class KVM {
    //ALT+SHIFT+B
    private Keyboard keyboard;
    private Display display;
    private Mouse mouse;

    public KVM(Keyboard keyboard, Display display, Mouse mouse) {
        this.keyboard = keyboard;
        this.display = display;
        this.mouse = mouse;
    }

/*
    @Deprecated
// no need becuase build method check everything
    public boolean fullyConfigured() {
        // TODO: add logic for minimum component's
        // must have at least one monitor
        // must have keyboard
        return false;
    }
*/

    public static class Builder {
        private Keyboard keyboard;
        private Display display;
        private Mouse mouse;

        public Builder withKeyboard(Keyboard keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder withDisplay(Display display) {
            this.display = display;
            return this;
        }

        public Builder withMouse(Mouse mouse) {
            this.mouse = mouse;
            return this;
        }

        public KVM build() {
            if (display == null) {
                throw new IllegalStateException("KVM with no display being built");
            }
            if (keyboard == null) {
                throw new IllegalStateException("KVM with no keyboard being built");
            }
            var kvm = new KVM(keyboard, display, mouse);

            return kvm;
        }
    }
}
