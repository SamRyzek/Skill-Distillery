## How to add swap space to your EC2 instance

The EC2 instance has a limited amount of memory.  Once you're running servers including Apache, Tomcat, and MySQL concurrently, you may see MySQL unable to restart with the error:

### Diagnostics
```
sudo grep memory /var/log/mysqld.log
InnoDB: Cannot allocate memory for the buffer pool
```

The `free` command shows how much memory is available.

```bash
free
             total       used       free     shared    buffers     cached
Mem:       1019280     938504      80776        148      55940     198512
-/+ buffers/cache:     684052     335228
Swap:            0          0          0
```

While there may seem to be free memory, there may not be as much as mysql wants to reserve.

### Fix

The quickest fix for this is to create a swap space so the server can allocate more virtual memory.

```bash
# Create a 500MB empty file:
sudo dd if=/dev/zero of=/swapfile bs=1M count=500
sudo sudo chmod 600 /swapfile

# Format it as swap space:
sudo mkswap /swapfile

# Enable it as active swap space
sudo swapon /swapfile

# Make sure it gets enabled at boot:
sudo -i      # Become superuser interactively
cat <<EoF >> /etc/fstab
/swapfile    swap       swap    defaults        0   0
EoF
exit         # Exit superuser

# Confirm swap is on and available:
free
#              total       used       free     shared    buffers     cached
# Mem:       1019280     939000      80280        148      56036     198528
# -/+ buffers/cache:     684436     334844
# Swap:       511996          0     511996

# Start mysqld
sudo service mysqld restart
```
